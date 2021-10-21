$('document').ready(function (){
    $('table #editButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (invoice){
            $('#idEdit').val(invoice.id);
            $('#ddlClientEdit').val(invoice.clientid);
            $('#ddlInvoiceStatusEdit').val(invoice.invoicestatusid);

            var invoiceDate = invoice.invoiceDate.substr(0,10);
            $('#dateEdit').val(invoiceDate);

            $('#remarksEdit').val(invoice.remarks);

        })
        $('#editInvoiceModal').modal();
    })

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);
        $('#deleteInvoiceModal').modal();
    })

    $('table #detailsButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (invoice){
            $('#idDetails').val(invoice.id);
            $('#ddlClientDetails').val(invoice.clientid);
            $('#ddlInvoiceStatusDetails').val(invoice.invoicestatusid);

            var invoiceDate = invoice.invoiceDate.substr(0,10);
            $('#invoiceDateDetails').val(invoiceDate);

            $('#remarksDetails').val(invoice.remarks);
        })
        $('#detailsInvoiceModal').modal();
    })
})