    function showSuggestions() {
    var decisions = [ 'A','B','C','D'];
var usernames = [
'free','associative','comp'
];

var result = $('#result');
result.html('');
for( var j=0;j<decisions.length;j++)
{
result.append('<div> <label class="col-sm-2"> ' + decisions[j]: + '</label><div class="col-sm-10">');
for (var i = 0; i < usernames.length; i++)
{
result.append('<div class="form-check form-check-inline">
                '<label class="form-check-label"><input class="form-check-input" type="radio" name=" ' + decisions[j]+
                '"value="' + usernames[i] + '" /> ' + usernames[i] + '</label></div>');
}
result.append('</div></div>');
}

}
