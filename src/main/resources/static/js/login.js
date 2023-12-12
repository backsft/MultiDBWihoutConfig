document.getElementById('loginForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Prepare data for the POST request
    const data = {
        username: username,
        password: password
    };

    // Send a POST request to the authentication endpoint
    fetch('/authenticate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Authentication failed');
        }
        return response.json();
    })
    .then(user => {
        // Authentication successful, do something with the user object
        console.log('Authenticated user:', user);

        // Hide the login form, show the chat interface, etc.
    })
    .catch(error => {
        console.error('Authentication error:', error);
        // Handle authentication error, e.g., show an error message to the user
    });
});
