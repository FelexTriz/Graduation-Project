from Mysql_op import sql_op
# 插入一个视频
class bili_sql_op:
    def __init__(self):
        self.mysqlop = sql_op('127.0.0.1','root','fengqiji2001','biyesheji')
    def insertVideo(self,video):
        self.mysqlop.insert('video',video)

