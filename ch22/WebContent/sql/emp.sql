select 'private '||decode(data_type,'VARCHAR2','String','NUMBER','int',data_type)||' '||
       lower(column_name)
  from cols
 where table_name='EMP';
 
 select distinct job from emp;
 
 select eno, ename, dname,loc 
   from emp e, dept d
  where e.dno = d.no
    and e.dno=10;
    
    select no||'.'||dname no from dept order by no;
 
 