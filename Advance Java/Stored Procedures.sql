drop procedure if Exists hi;
drop procedure if Exists GetName;
/*-----------------------------------------------*/

drop procedure if Exists hi;
delimiter $
create procedure hi()
begin
end $
select "Hello" as "message";
delimiter ;

/*-----------------------------------------------*/

drop procedure if Exists GetName;
delimiter $
create procedure GetName(in ID int , out Pname varchar(30))
begin
	select name into Pname from Product1 where id=ID;
end $
delimiter ;

/*-----------------------------------------------*/