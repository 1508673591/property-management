// pages/topic/index.js
const app = getApp();
var sliderWidth = 57.6; // 需要设置slider的宽度，用于计算中间位置
Page({

  /**
   * 页面的初始数据
   */
  data: {
    tabs: ["文章", "视频"],
    activeIndex: 0,
    type: 1
  },

  tabClick: function (e) {
    this.setData({
      activeIndex: e.currentTarget.id,
      sliderOffset: e.currentTarget.offsetLeft,
      type: parseInt(e.currentTarget.id) + 1
    });
    this.getTopic();
  },

  getTopic: function () {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/article/list',
      data: {
        type: that.data.type
      },
      success: function (res) {
        that.setData({
          topicList: res.data.articleList
        });
      }
    })
  },

  addTopic: function(){
    if (!app.globalData.userInfo.realName) {
      wx.navigateTo({
        url: '/pages/user-info/index',
      })
      return;
    }
    wx.navigateTo({
      url: '/pages/topic-add/index',
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          sliderLeft: (res.windowWidth / that.data.tabs.length - sliderWidth) / 2,
          sliderOffset: res.windowWidth / that.data.tabs.length * that.data.activeIndex
        });
      }
    });
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
    this.getTopic();
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

  }
})