create table board(
no number primary key,
name varchar2(20),
title varchar2(50),
content varchar2(2000),
password varchar2(20)
);

select 'private '||decode(data_type,'VARCHAR2','String','NUMBER','int',data_type)
      ||' '||lower(column_name) 
  from cols where table_name='BOARD';
  
  create sequence board_seq;
  
  select * from board order by no;
  

  