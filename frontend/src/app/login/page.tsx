'use client'

import { useLogin } from '@/lib/login'
import Link from 'next/link'

export default function Login() {
  const {
    email,
    password,
    setEmail,
    setPassword,
    errorEmail,
    errorPassword,
    error,
    handleSubmit,
  } = useLogin()
  return (
    <>
      <section className="bg-white">
        <div className="flex flex-col items-center justify-center px-6 py-8">
          <div className="w-full max-w-md ">
            <div className="p-6 space-y-4 ">
              <h1 className="font-heading font-bold text-center text-text text-2xl">
                Sign in
              </h1>
              <form onSubmit={handleSubmit} className="space-y-6">
                <div className="mt-10">
                  <label className="block font-body text-sm font-normal leading-19 text-left text-text mb-2">
                    Your email
                  </label>
                  <input
                    name="email"
                    id="email"
                    className="bg-gray-200 border border-solid border-gray-500 text-text rounded-lg focus:ring-red-500 focus:border-grey_800_color block w-full p-2.5"
                    placeholder="name@company.com"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                  ></input>
                  <span className="text-red_color text-sm font-medium">
                    {errorEmail ? <p>{errorEmail}</p> : null}
                  </span>
                </div>
                <div>
                  <label className="block font-body text-sm font-normal leading-19 text-left text-text mb-2">
                    Password
                  </label>
                  <input
                    type="password"
                    name="password"
                    id="password"
                    placeholder="••••••••"
                    className="bg-gray-200 border border-solid border-gray-500 text-gray-900 rounded-lg focus:ring-red-500 focus:border-grey_800_color block w-full p-2.5"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                  ></input>
                  <span className="text-red_color text-sm font-medium">
                    {errorPassword ? <p>{errorPassword}</p> : null}
                  </span>
                  <div className="flex justify-center">
                    <span className="text-red_color text-sm font-medium pt-5">
                      {error ? <p>{error}</p> : null}
                    </span>
                  </div>
                </div>

                <div className="flex flex-col items-center justify-center p">
                  <button
                    type="submit"
                    className="block w-32 bg-secondary font-heading text-md text-bold font-noraml text-white leading-22 text-center hover:bg-gray-400 focus:bg-gray-500 rounded-lg px-5 py-2.5  shadow-[0_4px_4px_0_rgba(0,0,0,0.25)]"
                  >
                    Submit
                  </button>
                  <Link
                    className="block font-body text-base  cursor-pointer leading-19 text-center text-gray-400 justify-center pt-5 pb-10"
                    href="/"
                  >
                    Forgot password?
                  </Link>
                  <p className="font-body text-normal font-normal leading-19 text-center">
                    Create an account{' '}
                    <Link
                      className="font-body text-bold font-bold cursor-pointer leading-19 text-center text-tex hover:underline dark:text-primary-500"
                      href="/"
                    >
                      Sign up
                    </Link>
                  </p>
                </div>
              </form>
            </div>
          </div>
        </div>
      </section>
    </>
  )
}
