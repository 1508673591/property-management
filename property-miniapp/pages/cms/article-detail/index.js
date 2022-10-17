// pages/news-detail/index.js

const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    news: {},
    isLike: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var articleId = options.id;
    this.setData({
      articleId: articleId
    })
    this.getDetail(options.id)
    this.isLike(options.id)
  },

  isLike: function(id){
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/article/isLike',
      data: {
        id: id,
        token: app.globalData.token
      },
      success: function (res) {
        if(res.data.code == 0){
          that.setData({
            isLike: res.data.isLike
          });
        }
        
      }
    })
  }, 
  getDetail: function(id){
    var that = this;
    var token = "";
    if (app.globalData.token) {
      token = app.globalData.token;
    }
    wx.request({
      url: app.globalData.domain + '/api/article/detail',
      data: {
        id: id,
        token: token
      },
      success: function (res) {
        var article = res.data.article;
        if(article.content){
          article.content = article.content.replace(/\<img/g, "<img style='max-width: 100%;'")
        }
        that.setData({
          news: article
        });
      }
    })
  },

  comment: function(e){
    var id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: '/pages/cms/comment/index?id='+id,
    })
  },

  commentList: function (e) {
    var id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: '/pages/cms/comment-list/index?id=' + id,
    })
  },

  getCommentList: function () {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/comment/list',
      data: {
        articleId: that.data.articleId
      },
      success: function (res) {
        that.setData({
          commentList: res.data.commentList,
          total: res.data.total
        })
      }
    })
  },

  liked: function(e){
    var news = this.data.news;
    var that = this;
    var id = e.currentTarget.dataset.id;
    if(news.liked){
      wx.showLoading();
      wx.request({
        url: app.globalData.domain + '/api/article/unliked',
        data: {
          articleId: id,
          token: app.globalData.token
        },
        success: function (res) {
          if (res.data.code == 0) {
            news.liked = false;
            that.setData({
              news: news,
              isLike: false
            })
          }
        },
        complete: function(res){
          wx.hideLoading();
        }
      })

      return;
    }
    
    wx.showLoading();
    wx.request({
      url: app.globalData.domain + '/api/article/liked',
      data: {
        articleId: id,
        token: app.globalData.token
      },
      success: function (res) {
        if(res.data.code == 0){
          news.liked = true;
          that.setData({
            news: news,
            isLike: true
          })
        }
      },
      complete: function(res){
        wx.hideLoading();
      }
    })
  },

  share: function(){

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.getCommentList();
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
    var path = '/pages/special-detail/index?id=' + this.data.news.id + "&distributor=" + app.globalData.distributor;
    return {
      title: this.data.news.title,
      path: path,
      success: function (res) {
        // 转发成功
      },
      fail: function (res) {
        // 转发失败
      }
    }
  }
})