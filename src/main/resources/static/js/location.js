$('document').ready(function() {

    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (location) {
            $('#idEdit').val(location.id);
            $('#cityEdit').val(location.city);
            $('#addressEdit').val(location.address);
            $('#ddlCountryEdit').val(location.countryid);
            $('#ddlRegionEdit').val(location.regionid);
        });
        $('#editLocationModal').modal();
    })

    $('table #deleteButton').on('click', function (event) {
        event.preventDefault();
        var href=$(this).attr('href')
        $('#confirmDeleteButton').attr('href', href)
        $('#deleteLocationModal').modal()
    })

    $('table #detailsButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (location) {
        $('#idDetails').val(location.id);
        $('#cityDetails').val(location.city);
        $('#addressDetails').val(location.address);
        $('#ddlCountryDetails').val(location.countryid);
        $('#ddlRegionDetails').val(location.regionid);

        })
        $('#detailsLocationModal').modal();
    })

})