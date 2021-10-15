$('document').ready(function() {

    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (country) {
            $('#idEdit').val(country.id);
            $('#countryEdit').val(country.name);
            $('#capitalEdit').val(country.capital);
            $('#codeEdit').val(country.code);
            $('#continentEdit').val(country.continent);
            $('#nationalityEdit').val(country.nationality);
        });
        $('#editCountryModal').modal();
    })
})