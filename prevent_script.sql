CREATE DATABASE prevent_db;prevent_db

CREATE TABLE prevent_log(
	
	id_prevent INT	NOT NULL AUTO_INCREMENT,
	data_log TIMESTAMP NOT NULL,
	ip VARCHAR(50) NOT NULL,
	request text NOT NULL,
	status_log int not NULL,
	user_agent TEXT not NULL,
	
	CONSTRAINT pk_id_prevent PRIMARY KEY (id_prevent)
)