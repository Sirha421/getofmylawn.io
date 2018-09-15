Our project code sample - we used python to build an rough authentification API provided by AUth0.

    session['jwt_payload'] = userinfo
    session['profile']={
        'user_id': userinfo['sub'],
        'name': userinfo['name'],
        'picture': userinfo['picture']
        }
    return redirect('/dashboard')

