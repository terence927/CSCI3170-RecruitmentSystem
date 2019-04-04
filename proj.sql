CREATE TABLE Position (

  Position_ID  varchar(6) primary key not null,

  Position_Title varchar(30) not null,

  Salary integer,
  
  Experience integer,
  
  Employer_ID varchar(4) not null,
  
  Status BOOLEAN
  
);
CREATE TABLE Employee (

  Employee_ID  varchar(6) primary key not null,

  Name varchar(30) not null,

  Expected_Salary integer,
  
  Experience integer,
  
  Skills varchar(50) not null
  
)
CREATE TABLE Company (

  Company   varchar(30) not null,

  Size integer,
  
  Founded varchar(4) not null
  
)
CREATE TABLE Employer (

  Employer_ID  varchar(6) primary key not null,

  Name varchar(30) not null,

  Company varchar(30) not null
  
)
CREATE TABLE History (

  Employee_ID  varchar(6) primary key not null,

  Company varchar(30) not null,
  
  Position_ID varchar(6) not null,
  
  Start Datetime,
  
  End Datetime
)