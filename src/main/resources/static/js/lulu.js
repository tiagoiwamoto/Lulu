new Vue({
    el: '#app',
    data: {
        loading: false,
        user: {
            name: '',
            email: '',
            password: ''
        },
        isAuthenticated: false,
        loadingUserCreation: false,
        loadingMedicationCreation: false,
        snackbarMsg: '',
        search: '',
        medications: [],
        medication: {
            id: null,
            commercialName: '',
            function: '',
            actionMechanism: '',
            recommendation: '',
            againstIndication: '',
            reference: '',
            status: '',
            stock: 0,
        }
    },
    mounted: function () {
        const tmpUser = JSON.parse(localStorage.getItem('x-user'));
        if(tmpUser !== null){
            this.user = tmpUser;
            this.isAuthenticated = true;
            this.recoverMedications();
        }
    },
    methods: {
        async performSaveMedication() {
            if(this.medication.commercialName === undefined || this.medication.commercialName.length < 1){
                this.snackbarMsg = 'Informe o nome comercial!';
                this.showSnackbar();
                return;
            }else if(this.medication.function === undefined || this.medication.function.length < 1){
                this.snackbarMsg = 'Informe a função!';
                this.showSnackbar();
                return;
            }else if(this.medication.actionMechanism === undefined || this.medication.function.actionMechanism < 1){
                this.snackbarMsg = 'Informe o mecanismo de ação!';
                this.showSnackbar();
                return;
            }else if(this.medication.recommendation === undefined || this.medication.recommendation.length < 1){
                this.snackbarMsg = 'Informe as recomendações!';
                this.showSnackbar();
                return;
            }else if(this.medication.againstIndication === undefined || this.medication.function.againstIndication < 1){
                this.snackbarMsg = 'Informe a(s) contra indicações!';
                this.showSnackbar();
                return;
            }else if(this.medication.reference === undefined || this.medication.function.reference < 1){
                this.snackbarMsg = 'Informe as referencias!';
                this.showSnackbar();
                return;
            }
            this.loadingMedicationCreation = true;
            const config = {
                headers: {'content-type': 'application/json'}
            };
            await axios
                .post('/v1/api/medications', JSON.stringify(this.medication), config)
                .then(response => {
                    this.snackbarMsg = response.data.message;
                    this.showSnackbar();
                })
                .catch(error => {
                    console.log(error)
                })
                .finally(() => {
                    this.loading = false;
                    this.loadingMedicationCreation = false;
                    this.recoverMedications();
                })
        },
        async recoverMedications() {
            this.loading = true;
            const config = {
                headers: {'content-type': 'application/json'}
            }
            await axios
                .get('/v1/api/medications', config)
                .then(response => {
                    this.medications = response.data.details;
                })
                .catch(error => {
                    console.log(error)
                })
                .finally(() => {
                    this.loading = false;
                })
        },
        async removeMedication(id) {
            const config = {
                headers: {'content-type': 'application/json', 'x-medication-id': id}
            }
            await axios
                .delete('/v1/api/medications', config)
                .then(response => {
                    this.snackbarMsg = response.data.message;
                    this.showSnackbar();
                    this.recoverMedications();
                })
                .catch(error => {
                    console.log(error)
                })
                .finally(() => this.loading = false)
        },
        async performSaveUser() {
            if(this.user.name === undefined || this.user.name.length < 1){
                this.snackbarMsg = 'Informe seu nome!';
                this.showSnackbar();
                return;
            }else if(this.user.email === undefined || this.user.email.length < 1){
                this.snackbarMsg = 'Informe seu email!';
                this.showSnackbar();
                return;
            }else if(this.user.password === undefined || this.user.password.length < 6){
                this.snackbarMsg = 'Informe uma senha com pelo menos 6 caracteres!';
                this.showSnackbar();
                return;
            }
            this.loadingUserCreation = true;
            const config = {
                headers: {'content-type': 'application/json'}
            }
            await axios
                .post('/v1/api/users', JSON.stringify(this.user), config)
                .then(response => {
                    this.user = response.data.details;
                    this.snackbarMsg = response.data.message;
                    this.showSnackbar();
                    localStorage.setItem('x-user', JSON.stringify(this.user));
                    isAuthenticated = true;
                    this.recoverMedications();
                    this.loadingUserCreation = false;
                    window.location.reload();
                })
                .catch(error => {
                    this.loadingUserCreation = false;
                    this.user = response.data.details;
                    this.snackbarMsg = error;
                    this.showSnackbar();
                })
        },
        async performLogin() {
            const config = {
                headers: {
                    'content-type': 'application/json',
                    'x-username': this.user.email,
                    'x-password': this.user.password
                }
            }
            await axios
                .post('/v1/api/users/login', null, config)
                .then(response => {
                    this.user = response.data.details;
                    this.snackbarMsg = response.data.message;
                    this.showSnackbar();
                    localStorage.setItem('x-user', JSON.stringify(this.user));
                    isAuthenticated = true;
                    window.location.reload();
                })
                .catch(error => {
                    this.snackbarMsg = error.response.data.message;
                    this.showSnackbar();
                })
        },
        async performSearchMedication() {
            const config = {
                headers: {
                    'content-type': 'application/json',
                    'x-search-medication': this.search
                }
            }
            await axios
                .get('/v1/api/medications/search', config)
                .then(response => {
                    this.medications = response.data.details;
                    if(this.medications.length === 0) {
                        this.snackbarMsg = 'Nenhuma medicação foi encontrada';
                        this.showSnackbar();
                    }
                })
                .catch(error => {
                    this.snackbarMsg = error.response.data.message;
                    this.showSnackbar();
                })
        },
        performLogout() {
            localStorage.removeItem('x-user');
            window.location.reload();
        },
        setMedicationToCreate(){
            this.medication = {};
        },
        selectMedication(medication){
            this.medication = medication;
        },
        showSnackbar() {
            // Get the snackbar DIV
            var x = document.getElementById("snackbar");

            // Add the "show" class to DIV
            x.className = "show";

            // After 3 seconds, remove the show class from DIV
            setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
        }
    }
})
