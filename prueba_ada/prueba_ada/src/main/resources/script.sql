CREATE TABLE version_company (
    version_company_id NUMBER PRIMARY KEY,
    company_id NUMBER,
    version_id NUMBER,
    version_company_description VARCHAR(255),
    CONSTRAINT fk_company FOREIGN KEY (company_id) REFERENCES company(company_id),
    CONSTRAINT fk_version FOREIGN KEY (version_id) REFERENCES version(version_id)
);