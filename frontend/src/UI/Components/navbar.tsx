import Image from 'next/image'
import Logo from '../../assets/svg/bowtie_1.svg';

export default function Navbar() {
    return (
        <header className="bg-grayN-600 top-0 start-0 w-full">
            <nav className="flex flex-wrap justify-between items-center py-5 px-6 md:px-10">
                <div className="h-10 flex items-center">
                    <Image className="w-12 md:w-14 lg:w-16" src={Logo} alt="logo" /><span className='text-grayN-100 text-xl md:text-2xl lg:text-3xl font-semibold ps-2'>Niles</span>
                </div>
                <div className="items-center text-center w-full hidden md:flex md:w-auto animate-fade-down animate-duration-500">
                    <ul className="font-medium text-xl text-grayN-100 flex flex-col pt-7 md:flex-row md:pt-0 gap-9 gap-x-5 lg:gap-x-9">
                        <li>
                            <a className="hover:text-grayN-200">Inicio</a>
                        </li>
                        <li>
                            <a className="hover:text-grayN-200">Categorias</a>
                        </li>
                        <li>
                            <a className="hover:text-grayN-200">Calendario</a>
                        </li>
                        <li>
                            <a className="hover:text-grayN-200">About</a>
                        </li>
                    </ul>
                </div>
                <div className="flex items-center justify-center">
                    <div className="size-10 md:size-14 bg-grayN-100 font-semibold text-xl md:text-3xl rounded-full flex items-center justify-center">M</div>
                    <div className="ps-5 text-grayN-100 md:hidden cursor-pointer">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth="1.5" stroke="currentColor" className="size-8">
                            <path strokeLinecap="round" strokeLinejoin="round" d="M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5" />
                        </svg>
                    </div>
                </div>
            </nav>
        </header>
    )
}