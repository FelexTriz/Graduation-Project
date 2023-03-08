import pymysql


class sql_op:
    def __init__(self, host, username, password, db_name):
        self.host = host
        self.username = username
        self.password = password
        self.db_name = db_name
        self.conn = pymysql.connect(
            host=self.host,
            user=self.username,
            password=self.password,
            db=self.db_name,
            charset='utf8mb4',
            cursorclass=pymysql.cursors.DictCursor
        )
        self.cur = self.conn.cursor()

    def close(self):
        self.conn.close()

    def execute_query(self, query, values=None):
        if values is None:
            self.cur.execute(query)
        else:
            self.cur.execute(query, values)
        self.conn.commit()
        return self.cur.fetchall()

    def insert(self, table_name, data):
        columns = ', '.join(data.keys())
        placeholders = ', '.join(['%s'] * len(data))
        query = f"INSERT INTO {table_name} ({columns}) VALUES ({placeholders})"
        self.execute_query(query, tuple(data.values()))

    def update(self, table_name, data, condition):
        columns = ', '.join(f"{key} = %s" for key in data)
        query = f"UPDATE {table_name} SET {columns} WHERE {condition}"
        values = tuple(data.values()) + tuple(condition.values())
        self.execute_query(query, values)

    def delete(self, table_name, condition):
        columns = ' AND '.join(f"{key} = %s" for key in condition)
        query = f"DELETE FROM {table_name} WHERE {columns}"
        self.execute_query(query, tuple(condition.values()))

    def select(self, table_name, columns=None, condition=None):
        if columns is None:
            columns = "*"
        if condition is None:
            query = f"SELECT {columns} FROM {table_name}"
            values = None
        else:
            columns_cond = ' AND '.join(f"{key} = %s" for key in condition)
            query = f"SELECT {columns} FROM {table_name} WHERE {columns_cond}"
            values = tuple(condition.values())
        return self.execute_query(query, values)
