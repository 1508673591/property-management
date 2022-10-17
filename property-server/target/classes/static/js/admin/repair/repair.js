$(function () {
	var columns = [

			{ checkbox: true, align: 'center' },
			{ title: '昵称', field: 'member.nickname' }, 			
			{ title: '姓名', field: 'realName' }, 			
			{ title: '电话', field: 'mobile' }, 			
			{ title: '地点', field: 'address' }, 			
			{ title: '问题描述', field: 'content' }, 			
			{ title: '状态', field: 'status' , formatter: function(value, row){
				if(value == 1){
					return '<span class="label label-default">待维修</span>';
				}else if(value == 2){
					return '<span class="label label-primary">已维修</span>';
				}
				return '';
			}}, 			
			{ title: '创建时间', field: 'createTime' }			
]

$("#table").bootstrapTable({
	        url: baseURL + 'repair/list',
	        cache: false,
	        striped: true,
	        pagination: true,
	        pageSize: 10,
	        pageNumber: 1,
	        sidePagination: 'server',
	        pageList: [10, 25, 50],
	        columns: columns,
	        queryParams: function (params) {
	        	return {
		        	page: params.offset / 10 + 1,
		        	limit: params.limit,
					content: vm.q.content
	        	}
	        }
	   });
});
var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		repair: {},
		q: {
			content: ''
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.repair = {};
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
		detail: function (event) {
			var id = getSelectedVal("id");
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "详情";
            
            vm.getInfo(id)
		},
		complete: function(){
			var ids = getSelectedVals("id");
			if(ids == null){
				return ;
			}
			confirm('确定要完成选中的记录？', function(){
			$.ajax({
				type: "POST",
			    url: baseURL + "repair/complete",
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
		saveOrUpdate: function (event) {
			var url = vm.repair.id == null ? "repair/save" : "repair/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.repair),
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
				    url: baseURL + "repair/delete",
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
			$.get(baseURL + "repair/info/"+id, function(r){
                vm.repair = r.repair;
            });
		},
		reload: function (event) {
			vm.showList = true;
			$('#table').bootstrapTable('refreshOptions',  {pageNumber: 1});
		}
	}
});