# 哔哩哔哩视频信息
import requests
import json
from py_mysql_op import bili_sql_op
class Video_Get:
    # 获得指定分区最新视频json
    def __init__(self):
        self.pyMySqlOp = bili_sql_op()
    def get_zone_newVideo(self,rid,pn,ps):
        params = {}
        if rid is not None:
            params['rid'] = rid
        if pn is not None:
            params['pn'] = pn
        if ps is not None:
            params['ps'] = ps
        restext = requests.get('https://api.bilibili.com/x/web-interface/ranking/v2',params).text
        videos = self.getJson(restext)['data']['list']
        # 视频json处理掉无用数据项
        for video in videos:
            state = video['stat']
            owner = video['owner']
            keep_keys=['bvid','tid','tname','copyright','pic','title','duration']
            new_video = {k: v for k, v in video.items() if k in keep_keys}
            print(new_video)
            self.pyMySqlOp.insertVideo(new_video)
        return videos
    #
    def getJson(self,res):
        return json.loads(res)
a = Video_Get()
a.get_zone_newVideo(1,1,5)

