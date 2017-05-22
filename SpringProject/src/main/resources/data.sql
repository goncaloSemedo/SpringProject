    
    insert into ATTRIBUTES values (1, 'Operating System', 1);
    insert into ATTRIBUTES values (2, 'Model', 0);
    insert into ATTRIBUTES values (3, 'Product', 0);
    insert into ATTRIBUTES values (4, 'Version', 1);
    insert into ATTRIBUTES values (5, 'Violated', 1);
    
	INSERT INTO USERS (username, password, UNIQUE_USER_ID, PROVISION_CODE, DEVICE_ID, DEVICE_FINGERPRINT)
  	VALUES('ss_admin','$2a$10$z4QJTlzCobBYZy9jxVm/3.3CNIIPr20Wv20NN/w1s.4yI1GigRS/e','$2a$10$vtRqng.QMSl94lzj2SFcdeSCg0qbQDX3CvVwZjwYvrW1CHGxsB0hG',
     		'BAC1SXQN',121, '$2a$10$vtRqng.QMSl94lzj2SFcdeSCg0qbQDX3CvVwZjwYvrW1CHGxsB0hG');

	insert into user_roles values (1, 'ROLE_ADMIN',1);

    insert into device_attributes 
    values(1,121,1,'Android');
    
    insert into device_attributes 
    values(2,121,2,'Xiaomi');
    
     insert into device_attributes 
    values(3,121,3,'Mi5s');
    
    insert into device_attributes 
    values(4,121,4,'5.0.5');
    
    insert into device_attributes 
    values(5,121,5,0);
    