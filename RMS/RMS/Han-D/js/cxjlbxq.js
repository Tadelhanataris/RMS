//$('#xg-btn').click(edit);

function edit(){
    $('#sc-btn').css("display","none");
    $('#xg-btn').css("display","none");
    $('#bc-btn').css("display","inline-block");
    $('#cz-btn').css("display","inline-block");
    $('#pwd').css("display","block");
    $('#photo').css("display","block");
    $("label.form-control").css("display","none");
    $("label.form-control + input").each(function(){
        $(this).css("display","table-cell").val($(this).prev().text());
    });
    $("label.form-control + select").each(function(){
        $(this).css("display","table-cell");
    });
    $("label.form-control + div").css("display","table-cell");
}