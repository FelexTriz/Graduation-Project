from database.Mysql_op import  sql_op

sqltest = sql_op('127.0.0.1','root','fengqiji2001','biyesheji')
select = sqltest.execute_query('select * from video')
print(select)
data = {'mid':1,'name':'原批','sex':'1','level':'1'}
sqltest.insert('user',data)
