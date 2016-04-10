$(window).load(function(){

    $("[name=yj]").change(function(){
        if($("#yes").prop("checked"))
        {
            $("#xz").after("<div class='row' id='dj'><div class='col-md-12'><div class='input-group'><span class='input-group-addon' id='xmdj'>项目等级</span><select class='form-control' aria-describedby='xmdj'><option>请选择</option><option value='gj'>国家级</option><option value='s'>市级</option><option value='x'>校级</option></select></div></div></div>");

            $("#xmdj + select").change(function(){
                debugger;
                if($("#xmdj + select").val()=="gj")
                {
                    $("#gjjbh").remove();
                    $("#sjbh").remove();
                    $("#xjbh").remove();

                    $("#dj").after("<div class='row' id='gjjbh'><div class='col-md-12'><div class='input-group'><span class='input-group-addon' id='gjj'>国家级项目编号</span><input type='text' class='form-control' aria-describedby='gjj'></div></div></div><div class='row' id='sjbh'><div class='col-md-12'><div class='input-group'><span class='input-group-addon' id='sj'>市级项目编号</span><input type='text' class='form-control' aria-describedby='sj'></div></div></div><div class='row' id='xjbh'><div class='col-md-12'><div class='input-group'><span class='input-group-addon' id='xj'>校级项目编号</span><input type='text' class='form-control' aria-describedby='xj'></div></div></div>");
                }
                else if($("#xmdj + select").val()=="s")
                {
                    $("#gjjbh").remove();
                    $("#sjbh").remove();
                    $("#xjbh").remove();

                    $("#dj").after("<div class='row' id='sjbh'><div class='col-md-12'><div class='input-group'><span class='input-group-addon' id='sj'>市级项目编号</span><input type='text' class='form-control' aria-describedby='sj'></div></div></div><div class='row' id='xjbh'><div class='col-md-12'><div class='input-group'><span class='input-group-addon' id='xj'>校级项目编号</span><input type='text' class='form-control' aria-describedby='xj'></div></div></div>");
                }
                else if($("#xmdj + select").val()=="x")
                {
                    $("#gjjbh").remove();
                    $("#sjbh").remove();
                    $("#xjbh").remove();

                    $("#dj").after("<div class='row' id='xjbh'><div class='col-md-12'><div class='input-group'><span class='input-group-addon' id='xj'>校级项目编号</span><input type='text' class='form-control' aria-describedby='xj'></div></div></div>");
                }
            });
        }
        else
        {
            $("#dj").remove();
            $("#gjjbh").remove();
            $("#sjbh").remove();
            $("#xjbh").remove();
        }
    });



});