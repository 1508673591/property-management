$(function () {
	var columns = [

			{ checkbox: true, align: 'center' },
			{ title: '会员', field: 'member.nickname' }, 			
			{ title: '评论', field: 'content' }, 			
			{ title: '创建时间', field: 'createTime', formatter: function(value, row){ return formatTime(value); }}			
]

$("#table").bootstrapTable({
	        url: baseURL + 'comment/list',
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
		        	content: vm.q.content
	        	}
	        }
	   });
});
var vm = new Vue({
	el:'#app',
	data:{
		showList: true,
		title: null,
		comment: {},
		q:{
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
			vm.comment = {};
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
			var url = vm.comment.id == null ? "comment/save" : "comment/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.comment),
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
				    url: baseURL + "comment/delete",
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
			$.get(baseURL + "comment/info/"+id, function(r){
                vm.comment = r.comment;
            });
		},
		reload: function (event) {
			vm.showList = true;
			$('#table').bootstrapTable('refresh',  {pageNumber: 1});
		}
	}
});