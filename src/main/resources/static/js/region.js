$('document').ready(function() {

    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (region) {
            $('#idEdit').val(region.id);
            $('#nameEdit').val(region.name);
            $('#ddlCountryEdit').val(region.countryid);
        });
        $('#editRegionModal').modal();
    })

    $('table #deleteButton').on('click', function (event) {
        event.preventDefault();
        var href=$(this).attr('href')
        $('#confirmDeleteButton').attr('href', href)
        $('#deleteRegionModal').modal()
    })

    $('table #detailsButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (region) {
        $('#idDetails').val(region.id);
        $('#nameDetails').val(region.name);
        $('#ddlCountryDetails').val(region.countryid);
        })
        $('#detailsRegionModal').modal();
    })

})