# 哔哩哔哩视频信息
import requests
import json
class Video_Get:
    # 获得指定分区最新视频json
    def get_zone_newVideo(self,rid,pn,ps):
        params = {}
        if rid is not None:
            params['rid'] = rid
        if pn is not None:
            params['pn'] = pn
        if ps is not None:
            params['ps'] = ps
        restext = requests.get('https://api.bilibili.com/x/web-interface/ranking/v2',params).text
        resJson = self.getJson(restext)
        return resJson
    #
    def getJson(self,res):
        return json.loads(res)

