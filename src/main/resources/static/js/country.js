$('document').ready(function() {

    $('#editButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (country) {
            $('#idEdit').val(country.id);
            $('#countryEdit').val(country.name);
            $('#capitalEdit').val(country.capital);
            $('#codeEdit').val(country.code);
        });
        $('#editCountryModal').modal();
    })

    $('table #deleteButton').on('click', function (event) {
        event.preventDefault();
        var href=$(this).attr('href')
        $('#confirmDeleteButton').attr('href', href)
        $('#deleteCountryModal').modal()
    })

    $('#detailsButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (country) {
        $('#idDetails').val(country.id);
        $('#codeDetails').val(country.code);
        $('#capitalDetails').val(country.capital);
        })
        $('#detailsCountryModal').modal();
    })

})