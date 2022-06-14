from pymysql import connect, cursors
import requests

# mariaDB 연결
conn = connect(host="localhost", user="green",
               password="green1234", db="greendb", charset="utf8")

cursor = conn.cursor()

# 공공데이터 담기
response = requests.get(
    "http://openapi.seoul.go.kr:8088/5875646654616b6935387676784375/json/RealtimeCityAir/1/25")


# 데이터 받기
responseParse = response.json()["RealtimeCityAir"]["row"]

# DB INSERT
insert_sql = "INSERT INTO weather(MSRDT, MSRRGN_NM, MSRSTE_NM, PM10, PM25, O3, NO2, CO, SO2, IDEX_NM, IDEX_MVL, ARPLT_MAIN) VALUES (%(MSRDT)s, %(MSRRGN_NM)s, %(MSRSTE_NM)s, %(PM10)s, %(PM25)s, %(O3)s, %(NO2)s, %(CO)s, %(SO2)s, %(IDEX_NM)s, %(IDEX_MVL)s, %(ARPLT_MAIN)s)"
cursor.executemany(insert_sql, responseParse)
conn.commit()
