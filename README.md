Our project code sample - we used python to build an rough authentification API provided by AUth0.


def requires_auth(f):
    @wraps(f)
    def decorate(*args, **kwargs):
        if 'profile' not in session:
            @app.route('/login')
            def login():
                return auth0.authorize_redirect(redirect_uri =' http://localhost:3000/callback', audience='https://getoffmylawn.auth0.com/userinfo')
            return redirect('/')
        returnf(*args, **kwargs)
        return decorated

@app.route('/dashboard')
@requires_auth
def dashboard():
    return render_template('dashboard.html',
                           userinfo=session['profile'],
                           userinfo_pretty=json.dumps(session['jwt_payload'], indent=4))
@app.route('/callback')
def callback_handling():
    auth0.authorize_access_token()
    resp = auth0.get('userinfor')
    userinfo = resp.json()

    session['jwt_payload'] = userinfo
    session['profile']={
        'user_id': userinfo['sub'],
        'name': userinfo['name'],
        'picture': userinfo['picture']
        }
    return redirect('/dashboard')

@app.route('/logout')
def logout():
    session.clear()
    params = {'returnTo': url_for('home',_external=True), 'client_id': 'PV3CP3453ypFoMT9daF9sb76pXM2LabM'}
    return redirect(auth0.api_base_url +'/v2/logout?' + urlencode(parems))

}


