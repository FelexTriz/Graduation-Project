import requests
import json
remen = requests.get('https://api.bilibili.com/x/web-interface/popular')
remen_data = json.loads(remen.text)
remen2= remen_data['data']['list'][1]['tname']
print(remen2)
# file = open("./test1.txt",mode='w')
# file.write(remen2)
# file.close
