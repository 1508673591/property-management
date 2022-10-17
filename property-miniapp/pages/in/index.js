//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    autoplay: true,
    interval: 3000,
    duration: 1000,
    bannerList: [],
    categoryList: [],
    articleList: [],
    isLoad: false,
    page: 1,
    pageSize: 10,
  },

  onLoad: function() {
    this.getAdvert()
    this.getArticle()
  },

  pay: function(){
    wx.navigateTo({
      url: '/pages/pay/index',
    })
  },

  onShow: function(){
    
  },

  upload(){
    wx.navigateTo({
      url: '/pages/upload/index',
    })
  },

  showInput: function () {
    wx.navigateTo({
      url: '/pages/shop/article/article-list/index',
    })
  },

  getAdvert: function() {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/advert/list',
      data: {
      },
      success: function(res) {
        that.setData({
          bannerList: res.data.advertList
        });
      }
    })
  },

  getArticle: function() {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/article/list',
      data: {
        page: that.data.page,
        limit: that.data.pageSize
      },
      success: function(res) {
        if (that.data.page == 1) {
          that.setData({
            articleList: []
          });
        }
        if (res.data.code != 0) {
          that.setData({
            isLoad: false
          });
          return;
        }
        if (res.data.articleList.length == 0) {
          that.setData({
            isLoad: true
          });
          return;
        }
        var article = that.data.articleList;
        for (var i = 0; i < res.data.articleList.length; i++) {
          article.push(res.data.articleList[i]);
        }
        that.setData({
          articleList: article,
          isLoad: false
        });
      }
    })
  },

  loadMore: function () {
    console.log("load more")
    var that = this;
    var isLoad = this.data.isLoad;
    console.log(isLoad)
    if (!isLoad) {
      this.setData({
        page: that.data.page + 1
      });
      //this.getArticle();
    }
  },

  onPullDownRefresh: function() {
    this.setData({
      page: 1
    });
    wx.showNavigationBarLoading()
    this.getAdvert();
    this.getArticle();
    setTimeout(function() {
      wx.hideNavigationBarLoading() //完成停止加载
      wx.stopPullDownRefresh() //停止下拉刷新
    }, 1000);
  },

  onShareAppMessage: function() {
    var path = '/pages/in/index';
    if (app.globalData.distributor) {
      path = path + "?distributor=" + app.globalData.distributor;
    }
    return {
      title: wx.getStorageSync('storeName'),
      path: path,
      success: function(res) {
        // 转发成功
      },
      fail: function(res) {
        // 转发失败
      }
    }
  },
  /**
  * 页面上拉触底事件的处理函数
  */
  onReachBottom: function () {
    this.loadMore();
  }
})