/**
 * Created by Administrator on 2017/8/1.
 */

 $(function () {
       var btns = $(".btns");
      
       btns.click(function(){
            $(this).attr("disabled",true);
            //console.log("dsads");
            var data_form = $(this).parent();
            //console.log(data_form);
            //在这里组合数据
            //var num = $("#num").val();
            //var pid = $("#pid").val();
            //var str_data = "?num="+num+"&pid="+pid;
            
            $.ajax({
                type:'post',
                url:'/addOrderItem',
                data:data_form.serialize(),
                cache:false,
                //dataType:'json',    //服务端展示没有使用json解析
                success:function(data){
                  var td_node = $(data_form).parent();
                   var mess_node = $(td_node).children().last();
                   $(mess_node).text("添加成功");
                   console.log(mess_node);
                   //span_message.innerHTML("添加成功");
                }
            });
       });

    });
