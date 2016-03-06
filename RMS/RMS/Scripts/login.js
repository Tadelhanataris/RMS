window.onload = function () {
    $('#login').click(function (e) {
        e.stopPropagation();
        $('#container').css("-webkit-filter", "blur(5px)");
        $('#container').css("-moz-filter", "blur(5px)");
        $('#container').css("-o-filter", "blur(5px)");
        $('#container').css("filter", "blur(5px)");
        $('.session-panel').css("-webkit-animation", "login-fadein 0.7s 0s 1 forwards");
        $('.session-panel').css("-moz-animation", "login-fadein 0.7s 0s 1 forwards");
        $('.session-panel').css("-o-animation", "login-fadein 0.7s 0s 1 forwards");
        $('.session-panel').css("animation", "login-fadein 0.7s 0s 1 forwards");
        $('.session-panel').show();
    })
    $('.session-panel').click(function (e) {
        if($('.session-panel').css('display')!='none')
        {
            e.stopPropagation();
        }
    })
    $(container).click(function ()
    {
        if($('.session-panel').css('display')!='none')
        {
            $('#container').css("-webkit-filter", "blur(0px)");
            $('#container').css("-moz-filter", "blur(0px)");
            $('#container').css("-o-filter", "blur(0px)");
            $('#container').css("filter", "blur(0px)");
            $('.session-panel').css("-webkit-animation", "login-fadeout 0.7s 0s 1 forwards");
            $('.session-panel').css("-moz-animation", "login-fadeout 0.7s 0s 1 forwards");
            $('.session-panel').css("-o-animation", "login-fadeout 0.7s 0s 1 forwards");
            $('.session-panel').css("animation", "login-fadeout 0.7s 0s 1 forwards");
            $('.session-panel').hide();
        }
    })
};