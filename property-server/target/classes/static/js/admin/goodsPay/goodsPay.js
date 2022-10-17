$(function () {
	var columns = [
        { checkbox: true, align: 'center' },
		{ title: '商品编号', field: 'goodsId' },
		{ title: '下单用户', field: 'member.realName' },
		{ title: '手机号', field: 'member.mobile'},

		];
	
	$("#table").bootstrapTable({
        url: baseURL + 'goodsPay/list',
        cache: false,
        striped: true,
        pagination: true,
        pageSize: 10,
        pageNumber: 1,
        sidePagination: 'server',
        columns: columns,
        queryParams: function (params) {
        	return {
	        	page: params.offset / params.limit + 1,
	        	limit: params.limit,
	        	goodsId: vm.q.goodsId,
	        	realName: vm.q.realName,
	        	mobile: vm.q.mobile
        	}
        }
	});
});

var vm = new Vue({
	el:'#app',
	data:{
		showList: true,
		title: null,
		goodsPay: {},
		q:{
			goodsId: '',
			realName: '',
			mobile: ''
		},
		memberList: []
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.goodsPay = {};
		},
		update: function (event) {
			var id = getSelectedVal("id");
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.goodsPay.id == null ? "goodsPay/save" : "goodsPay/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.goodsPay),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedVals("id");
			if(ids == null){
				return ;
			}

			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "goodsPay/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "goodsPay/info/"+id, function(r){
                vm.goodsPay = r.goodsPay;
            });
		},
		reload: function (event) {
			vm.showList = true;
			$('#table').bootstrapTable('refresh',  {pageNumber: 1});
		}
		
	}
});