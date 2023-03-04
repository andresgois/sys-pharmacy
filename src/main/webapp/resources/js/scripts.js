function verificar(xhr, status, args, dlg, tb) {
	console.log("Verificar");
    if(args.validationFailed) {
        PF(dlg).jq.effect("shake", {times:5}, 100);
    }
    else {
        PF(dlg).hide();
        PF(tb).clearFilters();
    }
}

console.log('Atualizado')
