import pymysql

# 建立连接
conn = pymysql.connect(host='localhost', user='root', password='fengqiji2001', database='biyesheji', charset='utf8mb4')

# 创建游标
cursor = conn.cursor()

# 执行 SQL 语句
cursor.execute('SELECT * FROM video LIMIT 10')

# 获取查询结果
results = cursor.fetchall()
print(results)
# 输出结果
for row in results:
    print(row)

# 关闭游标和连接
cursor.close()
conn.close()
