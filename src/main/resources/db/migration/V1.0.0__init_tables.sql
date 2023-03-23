CREATE TABLE store (
  store_code    INTEGER,
  creation_date DATETIME(6),
  PRIMARY KEY (store_code)
);

CREATE TABLE services_by_store (
  store_code    INTEGER,
  service_code  INTEGER,
  creation_date DATETIME(6),
  PRIMARY KEY (store_code, service_code),
  FOREIGN KEY (store_code) 	REFERENCES store(store_code)
);
