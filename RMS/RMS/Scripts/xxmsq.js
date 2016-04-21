window.onload = function() {
    $('[name=projectType]').change(function () {
        if ($(this).val()==4)
            $('[name=yxzzxmxq]').show();
        else
            $('[name=yxzzxmxq]').hide();
    });
    var i=1;
    $('#tjxcy').click(function () {
        $('#tjxcy').parent().parent().before("<div class='row'><div class='col-md-12 col sub-section'><p><span>成员</span><span>" + i + "</span></p></div></div><div class='row table-start'><div class='col-md-2 col col1 col-start'><p class='p1'>姓名</p></div><div class='col-md-2 col col1'><input type='text' class='form-control' id='cy" + i + "xm'></div><div class='col-md-1 col col1'><p class='p1'>性别</p></div><div class='col-md-2 col col1'><select id='cy" + i + "xb' class='form-control'><option value='male'>男</option><option value='female'>女</option></select></div><div class='col-md-2 col col1'><p class='p1'>学号</p></div><div class='col-md-3 col col1'><input type='text' class='form-control' id='cy" + i + "xh'></div></div><div class='row'><div class='col-md-2 col col1 col-start'><p class='p1' style='margin: -3px auto'>所在院（系）</p></div><div class='col-md-4 col col1'><select id='cy" + i + "yx' class='form-control'><option>请选择院系</option></select></div><div class='col-md-2 col col1'><p class='p1'>专业、班级</p></div><div class='col-md-4 col col1'><input type='text' class='form-control' id='cy" + i + "zy'></div></div><div class='row'><div class='col-md-2 col col1 col-start'><p class='p1'>分工</p></div><div class='col-md-10 col col1'><input type='text' class='form-control' id='cy" + i + "fg'></div></div><div class='row'><div class='col-md-2 col col1 col-start'><p class='p1'>电子邮箱</p></div><div class='col-md-4 col col1'><input type='text' class='form-control' id='cy" + i + "dzyx'></div><div class='col-md-2 col col1'><p class='p1'>联系电话</p></div><div class='col-md-4 col col1'><input type='text' class='form-control' id='cy" + i + "dh'></div></div><div class='row'><div class='col-md-2 col col1 col-start'><p class='p1'>手机</p></div><div class='col-md-4 col col1'><input type='text' class='form-control' id='cy" + i + "sj'></div><div class='col-md-2 col col1'><p class='p1'>身份证号</p></div><div class='col-md-4 col col1'><input type='text' class='form-control' id='cy" + i + "sfzh'></div></div>");
        i++;
        if (i > 4)
            $('#tjxcy').attr("disabled", "true");
    });
    $('[name^=fund]').change(function () {
        $('[name=totalfund]').text((0).toFixed(2));
        $('[name^=fund][name$=money]').each(function () {
            !isNaN(parseFloat($('[name=totalfund]:first').text())) &&
            !isNaN(parseFloat($(this).val())) &&
            $('[name=totalfund]').text((parseFloat($('[name=totalfund]:first').text()) + parseFloat($(this).val())).toFixed(2));
        })
    });
};