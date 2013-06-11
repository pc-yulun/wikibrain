/**
 * This class is generated by jOOQ
 */
package org.wikapidia.core.jooq;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "3.0.0"},
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked" })
public class Public extends org.jooq.impl.SchemaImpl {

	private static final long serialVersionUID = 1548699597;

	/**
	 * The singleton instance of <code>PUBLIC</code>
	 */
	public static final Public PUBLIC = new Public();

	/**
	 * No further instances allowed
	 */
	private Public() {
		super("PUBLIC");
	}

	@Override
	public final java.util.List<org.jooq.Sequence<?>> getSequences() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getSequences0());
		return result;
	}

	private final java.util.List<org.jooq.Sequence<?>> getSequences0() {
		return java.util.Arrays.<org.jooq.Sequence<?>>asList(
			org.wikapidia.core.jooq.Sequences.SYSTEM_SEQUENCE_1804A599_FE28_48FC_BCCC_FF4C0C8F334D,
			org.wikapidia.core.jooq.Sequences.SYSTEM_SEQUENCE_3D042512_79A5_4506_A697_EA8E37E69725,
			org.wikapidia.core.jooq.Sequences.SYSTEM_SEQUENCE_93A5AD82_3118_4CA8_91FA_48491DE1CAA7,
			org.wikapidia.core.jooq.Sequences.SYSTEM_SEQUENCE_9EC65A10_9713_4B11_A9CE_011F3A35E8FA);
	}

	@Override
	public final java.util.List<org.jooq.Table<?>> getTables() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final java.util.List<org.jooq.Table<?>> getTables0() {
		return java.util.Arrays.<org.jooq.Table<?>>asList(
			org.wikapidia.core.jooq.tables.Article.ARTICLE,
			org.wikapidia.core.jooq.tables.Link.LINK,
			org.wikapidia.core.jooq.tables.Concept.CONCEPT,
			org.wikapidia.core.jooq.tables.ArticleConcept.ARTICLE_CONCEPT,
			org.wikapidia.core.jooq.tables.LocalPage.LOCAL_PAGE,
			org.wikapidia.core.jooq.tables.UniversalPage.UNIVERSAL_PAGE);
	}
}
