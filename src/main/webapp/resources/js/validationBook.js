/**
 * Created by Sasha on 01.07.2015.
 */
function submitBookForm() {
    var name = $('#name').val().trim();
    var authors = $('#authors').val().trim();

    if(name.length == 0) {
        alert('Please enter name');
        $('#name').focus();
        return false;
    }

    if(authors.length == 0) {
        alert('Please enter authors');
        $('#authors').focus();
        return false;
    }

    return true;
};