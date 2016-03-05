window.onload = function () {
    $('#login').click(function (e) {
        e.stopPropagation();
        $('#container').css("-webkit-filter", "blur(5px)");
        $('.session-panel').css("animation", "login-fadein 0.5s 0s 1 forwards");
        $('.session-panel').show();
    })
    $(document).click(function()
    {
        if($('.session-panel').css('display')!='none')
        {
            $('#container').css("-webkit-filter", "blur(0px)");
            $('.session-panel').css("animation", "login-fadeout 0.5s 0s 1 forwards");
            $('.session-panel').hide();
        }
    })
};