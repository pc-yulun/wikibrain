package org.wikapidia.sr.normalize;

import com.typesafe.config.Config;
import org.wikapidia.conf.Configuration;
import org.wikapidia.conf.ConfigurationException;
import org.wikapidia.conf.Configurator;
import org.wikapidia.sr.SRResult;
import org.wikapidia.sr.SRResultList;

/**
 * A simple normalizer that returns log(1 + min-value).
 * In the case that an x is observed that is less than min-value, it returns 0.
 */
public class LogNormalizer implements Normalizer{
    private double c;
    private boolean trained = false;

    @Override
    public SRResultList normalize(SRResultList list) {
        SRResultList normalized = new SRResultList(list.numDocs());
        for (int i = 0; i < list.numDocs(); i++) {
            normalized.set(i, list.getId(i), list.getScore(i), normalize(list.getScore(i)));
        }
        return normalized;
    }

    @Override
    public double normalize(double x) {
        if (x < c) {
            return 0;
        } else {
            return Math.log(c + x);
        }
    }

    @Override
    public void observe(SRResultList sims, int rank, double y) {
        for (SRResult sr : sims) {
            observe(sr.getNormalized());
        }
    }

    @Override
    public void observe(double x, double y) {
        observe(x);
    }

    @Override
    public void observe(double x) {
        c = Math.min(x, 1 + c);
    }

    @Override
    public void observationsFinished() {
        trained = true;
    }

    @Override
    public boolean isTrained() {
        return trained;
    }

    @Override
    public String dump() {
        return "log normalizer: log(" + c + " + x)";
    }

    public static class Provider extends org.wikapidia.conf.Provider<LogNormalizer> {
        public Provider(Configurator configurator, Configuration config) throws ConfigurationException {
            super(configurator, config);
        }

        @Override
        public Class getType() {
            return Normalizer.class;
        }

        @Override
        public String getPath() {
            return "sr.normalizer";
        }

        @Override
        public LogNormalizer get(String name, Config config) throws ConfigurationException {
            if (!config.getString("type").equals("log")) {
                return null;
            }

            return new LogNormalizer(
            );
        }

    }
}
