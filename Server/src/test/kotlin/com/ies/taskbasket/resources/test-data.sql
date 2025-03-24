INSERT INTO task ( title, description, is_reminder_set, is_open, created_on, priority)
VALUES ( 'first test todo', 'first to desc', false , false , current_timestamp() , 'LOW');

INSERT INTO task ( title, description, is_reminder_set, is_open, created_on, priority)
VALUES ('second test todo', 'desc', true, false, CURRENT_TIME(), 'MEDIUM');

INSERT INTO task ( title, description, is_reminder_set, is_open, created_on, priority)
VALUES ('third test todo','third desc', true, true, CURRENT_TIME(), 'HIGH');

