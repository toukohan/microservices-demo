interface HeaderProps {
  title: string;
}

export default function Header({title}: HeaderProps) {
  return <header className="flex justify-between p-2">
    <div>{title}</div>
    <div className="flex gap-2">
      <button className="py-2 px-4 bg-slate-500 text-white rounded">Login</button>
      <button className="py-2 px-4 bg-slate-300 text-slate-800 rounded">Sign In</button>
    </div>
  </header>
}