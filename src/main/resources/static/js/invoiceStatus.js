$('document').ready(function (){
    $('table #editButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (invoiceStatus){
            $('#idEdit').val(invoiceStatus.id);
            $('#descriptionEdit').val(invoiceStatus.description);
            $('#detailsEdit').val(invoiceStatus.details);
        })
        $('#editInvoiceStatusModal').modal();
    })

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);
        $('#deleteInvoiceStatusModal').modal();
    })

    $('table #detailsButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (invoiceStatus){
            $('#idDetails').val(invoiceStatus.id);
            $('#descriptionDetails').val(invoiceStatus.description);
            $('#detailsDetails').val(invoiceStatus.details);
        })
        $('#detailsInvoiceStatusModal').modal();
    })
})