CREATE INDEX IF NOT EXISTS UNIVERSAL_PAGE_IDX_PAGE_ID ON UNIVERSAL_PAGE(UNIV_ID, ALGORITHM_ID);
CREATE INDEX IF NOT EXISTS UNIVERSAL_PAGE_IDX_LOCAL_PAGE_ID ON UNIVERSAL_PAGE(LANG_ID, PAGE_ID, ALGORITHM_ID);
CREATE INDEX IF NOT EXISTS UNIVERSAL_PAGE_IDX_PAGE_TYPE ON UNIVERSAL_PAGE(UNIV_ID, ALGORITHM_ID, NAME_SPACE)
