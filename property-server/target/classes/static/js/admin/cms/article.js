$(function () {
	var columns = [
			{ checkbox: true, align: 'center' },
			{ field: 'picUrl', title: '图片', formatter: function(value, row, index){
       			return value ? '<img width="60px" src="'+value+'"></img>' : '';
       		} }, 			
			{ field: 'title', title: '标题' }, 		
			{ field: 'type', title: '文章类型', formatter: function(value, row, index){
				if(value == 1){
					return '文章';
				}else if(value == 2){
					return '视屏';
				}else if(value == 3){
					return '腾讯视屏'
				}
       		}}, 			
			{ field: 'likedNum', title: '点赞数量' }, 			
			{ field: 'commentNum', title: '评论数量' }, 		
			{ field: 'publishDate', title: '发布时间'}			
];

$("#table").bootstrapTable({
	        url: baseURL + 'article/list',
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
		        	limit: params.limit
	        	}
	        }
	   });
});

var setting = {
	data: {
		simpleData: {
			enable: true,
			idKey: "id",
			pIdKey: "parentId",
			rootPId: -1
		},
		key: {
			url:"nourl",
			name: 'columnName'
		}
	},
	callback: {
		onClick: zTreeOnClick
	}
};

function zTreeOnClick(event, treeId, treeNode) {
	vm.q.columnId = treeNode.id;
	vm.query();
};

var ztree;

var vm = new Vue({
	el:'#app',
	data:{
		showList: true,
		title: null,
		article: {
			columnName: ''
		},
		q: {
			title: "",
			columnId: ''
		},
		columnList: []
	},
	methods: {
		query: function () {
			vm.reload();
		},
		getColumn: function(){
            //加载菜单树
            $.get(baseURL + "column/list", function(r){
                ztree = $.fn.zTree.init($("#columnTree"), setting, r);
                var node = ztree.getNodeByParam("id", vm.article.columnId);
                if(node){
                	ztree.selectNode(node);
                	vm.article.columnName = node.columnName;
                }
            })
        },
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.article = {
				type: 1,
				columnId: ''
			};
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
			var url = vm.article.id == null ? "article/save" : "article/update";
			vm.article.content = ue.getContent();
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.article),
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
				    url: baseURL + "article/delete",
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
			$.get(baseURL + "article/info/"+id, function(r){
                vm.article = r.article;
                ue.ready(function() {
					ue.setContent(r.article.content);
			    });
            });
		},
		columnTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择栏目",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#columnLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    vm.article.columnId = node[0].id;
                    vm.article.columnName = node[0].columnName;
                    $("#columnName").val(node[0].columnName);
                    layer.close(index);
                }
            });
        },
		getColumns: function(){
			$.getJSON(baseURL + "column/list", function(r){
                vm.columnList = r;
            })
		},
		reload: function (event) {
			vm.showList = true;
			$('#table').bootstrapTable('refresh',  {pageNumber: 1, query: vm.q});
		}
	},
	created: function(){
		
	}
});