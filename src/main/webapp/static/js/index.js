/**
 * <p>
 * @author hiYuzu
 * @description index
 * @version V1.0
 * </p>
 * @date 2018/11/16 10:00
 */
loadMain('home');
function loadMain(page) {
    $("#main").empty();
    var html = '<object type="text/html" data="static/html/' + page + '.html" width="100%" height="100%" style="overflow: auto;"></object>';
    $("#main").append(html);
}