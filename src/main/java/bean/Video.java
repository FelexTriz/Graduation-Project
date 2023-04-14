package bean;

public class Video {
    public String title;
    public String bvid;
    public int tid;
    public Long owner_mid;
    public int copyright;
    public int view;
    public int danmaku;
    public int reply;
    public int favorite;
    public int coin;
    public int share;
    public int dianzan;
    public String tname;
    public String pic;
    public int duration;
    public String jianjie;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBvid() {
        return bvid;
    }

    public void setBvid(String bvid) {
        this.bvid = bvid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public Long getOwner_mid() {
        return owner_mid;
    }

    public void setOwner_mid(Long owner_mid) {
        this.owner_mid = owner_mid;
    }

    public int getCopyright() {
        return copyright;
    }

    public void setCopyright(int copyright) {
        this.copyright = copyright;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getDanmaku() {
        return danmaku;
    }

    public void setDanmaku(int danmaku) {
        this.danmaku = danmaku;
    }

    public int getReply() {
        return reply;
    }

    public void setReply(int reply) {
        this.reply = reply;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public int getDianzan() {
        return dianzan;
    }

    public void setDianzan(int dianzan) {
        this.dianzan = dianzan;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", bvid='" + bvid + '\'' +
                ", tid='" + tid + '\'' +
                ", owner_mid=" + owner_mid +
                ", copyright=" + copyright +
                ", view=" + view +
                ", danmaku=" + danmaku +
                ", reply=" + reply +
                ", favorite=" + favorite +
                ", coin=" + coin +
                ", share=" + share +
                ", dianzan=" + dianzan +
                ", tname='" + tname + '\'' +
                ", pic='" + pic + '\'' +
                ", duration=" + duration +
                ", jianjie='" + jianjie + '\'' +
                '}';
    }
}
