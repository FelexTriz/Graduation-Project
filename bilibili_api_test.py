import requests
import json

# 获取热门视频
remen = requests.get('https://api.bilibili.com/x/web-interface/popular')
remen_data = json.loads(remen.text)

# 获得单个视频信息
for video in remen_data['data']['list']:
    video_title = video['title']
    video_bvid = video['bvid']
    video_tid = video['tid']
    video_owner = video['owner']

# remen2= remen_data['data']['list'][0]['title']
# print(remen2)


# file = open("./test1.txt",mode='w')
# file.write(remen2)
# file.close
