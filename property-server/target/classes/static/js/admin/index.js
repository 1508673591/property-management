var vm = new Vue({
	el:'#app',
	data:{
		statistics:{}
	},
	methods: {
		query: function() {
			$.get(baseURL + "statistics/query",{},function(r){
				vm.statistics = r.statistics
				
				$("#main").css("width", $(".content-header").width() - 50);
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('main'));

                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: ''
                    },
                    tooltip: {},
                    legend: {
                        data:['缴费']
                    },
                    xAxis: {
                        data: r.statistics.payCountList.map(function(v){return v.createTime})
                    },
                    yAxis: {
                        minInterval: 1,
                    },
                    series: [{
                        name: '缴费金额',
                        type:'bar',
                        data: r.statistics.payCountList.map(function(v){return v.amount})
                    }]
                };

                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);

				$("#repair").css("width", $(".content-header").width() - 50);
                // 基于准备好的dom，初始化echarts实例
                var repairChart = echarts.init(document.getElementById('repair'));

                // 指定图表的配置项和数据
                var typeOption = {
            		title: {
                        text: ''
                    },
                    tooltip: {},
                    legend: {
                    },
                    series: [{
                        name: '报修统计',
                        type:'pie',
                        data: r.statistics.repairCountList.map(function(v){return {value: v.count, name: v.name}})
                    }]
                };

                // 使用刚指定的配置项和数据显示图表。
                repairChart.setOption(typeOption);

			});
		}
	},
	
	created: function(){
		this.query();
	}
});
