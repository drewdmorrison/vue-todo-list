BEGIN TRANSACTION;

DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS task_statuses;

DROP SEQUENCE IF EXISTS seq_task_status_id;
DROP SEQUENCE IF EXISTS seq_task_id;

CREATE SEQUENCE seq_task_status_id
        INCREMENT BY 1
        NO MAXVALUE
        NO MINVALUE
        CACHE 1;
        

CREATE SEQUENCE seq_task_id
        INCREMENT BY 1
        START WITH 1001
        NO MAXVALUE
        NO MINVALUE
        CACHE 1;
        
CREATE TABLE task_statuses (
        task_status_id int DEFAULT nextval('seq_task_status_id'::regclass) NOT NULL,
        task_status_desc varchar(20) NOT NULL,
        CONSTRAINT PK_task_statuses PRIMARY KEY (task_status_id)
);

CREATE TABLE tasks (
        task_id int DEFAULT nextval('seq_task_id'::regclass) NOT NULL,
        task_name varchar(75) NOT NULL,
        task_desc varchar (250) NOT NULL,
        due_date DATE NOT NULL,
        task_status_id int NOT NULL,
        CONSTRAINT PK_tasks PRIMARY KEY (task_id),
        CONSTRAINT FK_tasks_task_statuses FOREIGN KEY (task_status_id) REFERENCES task_statuses (task_status_id)
);

INSERT INTO task_statuses (task_status_desc) VALUES ('In Progress');
INSERT INTO task_statuses (task_status_desc) VALUES ('Completed');

COMMIT TRANSACTION;